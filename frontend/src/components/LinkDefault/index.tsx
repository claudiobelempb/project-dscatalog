import Link from 'next/link';
import styles from './styles.module.scss';

type LinkProps = {
  title: string;
  href: string;
  target: boolean;
};

const LinkDefault: React.FC<LinkProps> = ({ title, href, target }) => {
  const tab = target ? '_blank' : '_self';
  return (
    <Link href={href}>
      <a id={styles.LinkContainer} target={tab}>
        {title}
      </a>
    </Link>
  );
};

export { LinkDefault };
