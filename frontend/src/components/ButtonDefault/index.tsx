import Image from 'next/image';
import { ButtonLarge, ButtonMedium, ButtonSmall, ButtonFull } from './styles';

type HeadingProps = {
  size?: 'large' | 'medium' | 'small' | 'full' | 'search';
  color?: boolean;
  uppercase?: boolean;
  title: string;
  onClick: () => void;
  icon?: boolean;
  alt?: string;
  src: string;
};

export const ButtonDefault: React.FC<HeadingProps> = ({
  color = false,
  size = `large`,
  uppercase,
  title = 'Button',
  icon = false,
  alt,
  src,
  onClick,
}) => {
  const isColor = color ? color : 'color_black-500';
  const isUppercase = uppercase ? `${uppercase}` : 'none';
  const renderButton = () => {
    switch (size) {
      case 'large':
        return (
          <ButtonLarge
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={60} height={60} /> : ''}
          </ButtonLarge>
        );
      case 'medium':
        return (
          <ButtonMedium
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={48} height={48} /> : ''}
          </ButtonMedium>
        );
      case 'small':
        return (
          <ButtonSmall
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={48} height={48} /> : ''}
          </ButtonSmall>
        );
      case 'full':
        return (
          <ButtonFull
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={48} height={48} /> : ''}
          </ButtonFull>
        );
      case 'search':
        return (
          <ButtonFull
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={48} height={48} /> : ''}
          </ButtonFull>
        );

      default:
        return (
          <ButtonLarge
            onClick={onClick}
            className={`${isColor} ${size} ${isUppercase}`}
          >
            {title}
            {icon ? <Image src={src} alt={alt} width={60} height={60} /> : ''}
          </ButtonLarge>
        );
    }
  };

  return renderButton();
};
