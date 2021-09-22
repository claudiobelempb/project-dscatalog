import { ReactNode } from 'react';
import { Container } from '../Container';
import { Content } from '../Content';
import { HeaderContainer } from './styles';

type HeaderPros = {
  children?: ReactNode;
};

const Header: React.FC<HeaderPros> = ({ children }) => {
  return (
    <HeaderContainer>
      <Container>
        <Content>{children}</Content>
      </Container>
    </HeaderContainer>
  );
};

export { Header };
