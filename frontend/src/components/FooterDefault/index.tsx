import { ContainerDefault } from '../ContainerDefault';
import { ContentDefault } from '../ContentDefault';
import { FooterContainer } from './styles';

type FooterProps = {
  children: React.ReactNode;
};

const FooterDefault: React.FC<FooterProps> = ({ children }) => {
  return (
    <FooterContainer>
      <ContainerDefault>
        <ContentDefault>{children}</ContentDefault>
      </ContainerDefault>
    </FooterContainer>
  );
};

export { FooterDefault };
